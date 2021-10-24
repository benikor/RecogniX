pipeline {
  agent {
    kubernetes {
      yamlFile 'deployment/agents/jenkins-agent-allinone.yaml'
      defaultContainer 'docker'
      //idleMinutes 60
    }
  }

  stages {

        stage('build backend image') {
          when {
            anyOf {
              changeset 'backend/**'
              expression {
                image_id = sh (script: "docker images -q ${IMAGEREPO}/${BE_IMAGETAG}", returnStdout: true).trim()
                if (image_id.isEmpty()) return true
              }

            }

          }
          steps {
            container(name:'maven'){
               sh 'mvn -B -DskipTests -f backend/pom.xml clean package install'

                }
            sh 'docker buildx create  --driver kubernetes --name builder --node arm64node  --driver-opt replicas=1,nodeselector=kubernetes.io/arch=arm64 --use'
            sh 'docker buildx create --append --driver kubernetes --name builder --node amd64node  --driver-opt replicas=1,nodeselector=kubernetes.io/arch=amd64 --use'
            sh 'docker buildx build -t ${IMAGEREPO}/${BE_IMAGETAG} --platform linux/arm64,linux/amd64 --push backend/. '
            sh 'sed -i "s/BE_JENKINS_WILL_CHANGE_THIS_WHEN_REDEPLOY_NEEDED_BASED_ON_CHANGE/$(date)/" k8s/recognix_deployment.yaml'
          }
        }

        stage('build frontend image') {
          when {
            anyOf {
              changeset 'frontend/**'
              expression {
                image_id = sh (script: "docker images -q ${IMAGEREPO}/${FE_IMAGETAG}", returnStdout: true).trim()
                if (image_id.isEmpty()) return true
              }

            }

          }
          steps {
            sh 'docker buildx build -t ${IMAGEREPO}/${FE_IMAGETAG} --platform linux/arm64,linux/amd64 --push frontend/.'
            sh 'sed -i "s/FE_JENKINS_WILL_CHANGE_THIS_WHEN_REDEPLOY_NEEDED_BASED_ON_CHANGE/$(date)/" k8s/recognix_deployment.yaml'
          }
        }

    stage('deploy ') {
      steps {
        sh '''
        cp -i deployment/recognix_deployment.yaml k8s/deployment.yaml
        sed -i "s/BRANCHNAME/${BRANCH_NAME_LC}/" k8s/deployment.yaml
        sed -i "s/BE_IMAGETAG/${IMAGEREPO}\\/${BE_IMAGETAG}/" k8s/deployment.yaml
        sed -i "s/FE_IMAGETAG/${IMAGEREPO}\\/${FE_IMAGETAG}/" k8s/deployment.yaml
        '''
        sh 'cat k8s/deployment.yaml'
        container(name: 'kubectl') {
        sh 'kubectl apply -f k8s/deployment.yaml'
        sh 'kubectl rollout status deployment/birdnoise-be --namespace=birdnoise-${BRANCH_NAME_LC}'
        sh 'kubectl rollout status deployment/birdnoise-fe --namespace=birdnoise-${BRANCH_NAME_LC}'

        sh '''curl --location --request POST \'https://discord.com/api/webhooks/827513686460989490/wWHavHLlBi1FCa_UkoPk8v0nqs9APg9bPWHf63RLhZejSOSPJk1Db57Tc7WXDGK7eU8g\'         --header \'Content-Type: application/json\'         --data-raw \'{"content": "I am pleased to report that I am deployed the branch:** \'${BRANCH_NAME_LC}\'** and its available for you at: http://\'${BRANCH_NAME_LC}\'.birdnoise.klucsik.fun "}\'
        '''
        }
      }
    }

  }
  environment {
    BRANCH_NAME_LC = """${sh(
                                   script:
                                      "echo $BRANCH_NAME | sed -e 'y/ABCDEFGHIJKLMNOPQRSTUVWXYZ/abcdefghijklmnopqrstuvwxyz/'",
                                   returnStdout:true
                                   ).trim()}"""
    BE_IMAGETAG = """${sh(
                                  script:
                                    "BRANCH_NAME_LC=\$(echo $BRANCH_NAME | sed -e 'y/ABCDEFGHIJKLMNOPQRSTUVWXYZ/abcdefghijklmnopqrstuvwxyz/') echo recognix_be_$BRANCH_NAME_LC",
                                  returnStdout:true
                                  ).trim()}"""
    FE_IMAGETAG = """${sh(
                                    script:
                                      "BRANCH_NAME_LC=\$(echo $BRANCH_NAME | sed -e 'y/ABCDEFGHIJKLMNOPQRSTUVWXYZ/abcdefghijklmnopqrstuvwxyz/') echo recognix_fe_$BRANCH_NAME_LC",
                                    returnStdout:true
                                    ).trim()}"""
    TEST_BRANCNAME = """${sh(
                                  script:
                                    "BRANCH_NAME_LC=\$(echo $BRANCH_NAME | sed -e 's/\\(.*\\)/\\L\\1/') echo apitest-$BRANCH_NAME_LC",
                                  returnStdout:true
                                  ).trim()}"""
      IMAGEREPO = 'registry.klucsik.fun'
        }
}
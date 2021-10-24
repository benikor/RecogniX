pipeline {
  agent {
    kubernetes {
      yamlFile 'deployment/agent/jenkins-agent-allinone.yaml'
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
            sh 'docker buildx create --append --driver kubernetes --name builder --node amd64node  --driver-opt replicas=1,nodeselector=kubernetes.io/arch=amd64 --use'
            sh 'docker buildx build -t ${IMAGEREPO}/${BE_IMAGETAG} --platform linux/amd64 --push backend/. '
            sh 'sed -i "s/BE_JENKINS_WILL_CHANGE_THIS_WHEN_REDEPLOY_NEEDED_BASED_ON_CHANGE/$(date)/" deployment/recognix_deployment.yaml'
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
            sh 'cp frontend/src/environments/environment.deploy.ts frontend/src/environments/environment.ts'
            sh 'docker buildx build -t ${IMAGEREPO}/${FE_IMAGETAG} --platform linux/amd64 --push frontend/.'
            sh 'sed -i "s/FE_JENKINS_WILL_CHANGE_THIS_WHEN_REDEPLOY_NEEDED_BASED_ON_CHANGE/$(date)/" deployment/recognix_deployment.yaml'
          }
        }

    stage('deploy ') {
      steps {
        sh '''
        cp -i deployment/recognix_deployment.yaml deployment/deployment.yaml
        sed -i "s/BRANCHNAME/${BRANCH_NAME_LC}/" deployment/deployment.yaml
        sed -i "s/BE_IMAGETAG/${IMAGEREPO}\\/${BE_IMAGETAG}/" deployment/deployment.yaml
        sed -i "s/FE_IMAGETAG/${IMAGEREPO}\\/${FE_IMAGETAG}/" deployment/deployment.yaml
        '''
        sh 'cat deployment/deployment.yaml'
        container(name: 'kubectl') {
        sh 'kubectl delete -f deployment/deployment.yaml'
        sh 'kubectl apply -f deployment/deployment.yaml'
        sh 'kubectl rollout status deployment/recognix-be --namespace=recognix-${BRANCH_NAME_LC}'
        sh 'kubectl rollout status deployment/recognix-fe --namespace=recognix-${BRANCH_NAME_LC}'

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
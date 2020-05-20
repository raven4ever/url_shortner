def namespace = 'dev-env'
def appName = 'url-shortner-backend'

pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        script {
          openshift.withCluster() {
              openshift.withProject("${namespace}") {
                def bld = openshift.startBuild("${appName}")
                bld.untilEach {
                  return it.object().status.phase == "Running"
                }
                bld.logs('-f')
              }
          }
        }
      }
    }
    stage('verify deployment in dev') {
      steps {
        script {
          openshift.withCluster() {
            openshift.withProject("${namespace}") {
              def dc = openshift.selector('dc', "${appName}")
              // this will wait until the desired replicas are available
              dc.rollout().status()
            }
          }
        }
      }
    }
  }
}

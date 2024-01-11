pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'ls -ls'
            }
        }
    }
    post {
        always {
            echo 'always finished'
            deleteDir() /* clean up our workspace */
        }
        aborted {
            echo 'Project aborted...'
        }
        changed {
            echo 'Things were different before...'
        }
        success {
            echo 'I succeeded'
        }
        unstable {
            echo 'I am unstable...'
        }
        failure {
            echo 'I failed :/'
        }
    }
}

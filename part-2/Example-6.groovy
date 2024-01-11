pipeline {
    agent any
    options {
        timestamps()
        buildDiscarder logRotator(daysToKeepStr: '3',
                                  numToKeepStr: '3' )
        /* All Project: pipeline
           Timeout set to expire in 20 min */
        timeout(time: 20, unit: 'MINUTES')
    }
    stages {
        stage('Build') {
            options {
                /* Stage: Build
                   Timeout set to expire in 1 min 0 sec  */
                timeout(time: 1, unit: 'MINUTES')
            }
            steps {
                echo "build ${env.BUILD_ID} on ${env.JENKINS_URL}"
                /* Sleeping for 1 min 40 sec */
                sleep 100
            }
        }
    }
}

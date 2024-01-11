pipeline {
    agent any
    environment {
        javaVersion = '/usr/var/java8'
    }
    stages {
        stage('Example Username/Password') {
            environment {
                SERVICE_CREDS = credentials('tomcat9Cred')
            }
            steps {
                /* Masking supported pattern matches
                    of $SERVICE_CREDS
                    or $SERVICE_CREDS_USR
                    or $SERVICE_CREDS_PSW */
                echo "Service user is $SERVICE_CREDS_USR"
                sh 'echo "Service password is $SERVICE_CREDS_PSW"'
            }
        }
        stage('Build') {
            steps {
                echo "build ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo "This is path ${env.javaVersion}"
                echo "This is path $javaVersion"
                sh 'printenv'
            }
        }
    }
}

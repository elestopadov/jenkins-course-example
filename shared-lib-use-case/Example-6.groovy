@Library('test-library') _

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Hello Pipeline'
                script {
                    buildProject name: 'TestProject006'
                }
            }
        }
    }
}

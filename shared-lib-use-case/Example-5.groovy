@Library('test-library') _

pipeline {
    agent any
    stages {
        stage('Example-5') {
            steps {
                echo 'Check example-5'
                script {
                    printMessage()
                    printMessage('ExampleFIVE')
                }
            }
        }
    }
}
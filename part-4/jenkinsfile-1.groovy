pipeline {
    agent any
    tools {
        maven 'mvn_3_6_3'
    }
    triggers {
        cron('H/55 * * * 1-5')
    }
    options {
        timestamps()
        buildDiscarder logRotator(daysToKeepStr: '7',
                                   numToKeepStr: '14' )
        timeout(time: 10, unit: 'MINUTES')
    }
    stages {
        stage('Get-code') {
            steps {
                git branch: 'main', url: 'https://github.com/elestopadov/jenkins-example-app.git'
            }
        }
        stage('Build') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn -f my-app/pom.xml clean package sonar:sonar'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Run Acceptance Test-UI'
                echo 'testing.....'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy to DEV'
                sh 'java -jar my-app/target/*.jar'
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archive '**/my-app/target/*.jar'
            deleteDir() /* clean up our workspace */
        }
        aborted {
            echo 'Project aborted...'
        }
        success {
            echo 'I succeeded'
        }
        failure {
            echo 'I failed :/'
        }
    }
}

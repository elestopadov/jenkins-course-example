pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'This is stage 1'
            }
        }
        stage('Parallel-Stages') {
            failFast true
            parallel {
                stage('Deploy to Dev-1') {
                    steps {
                        echo 'Deploy to dev-1'
                        sleep 25
                    }
                    post {
                        success {
                            echo 'Deploy to dev-1 [ success notification ]'
                        }
                        failure {
                            echo 'Deploy to dev-1 [ failure notification ]'
                        }
                    }
                }
                stage('Deploy to Dev-2') {
                    steps {
                        echo 'Deploy to dev-1'
                        sleep 10
                    }
                    post {
                        success {
                            echo '>> dev-2 [ success notification ]'
                        }
                        failure {
                            echo '>> dev-2 [ failure notification ] '
                        }
                    }
                }
            }
        }
    }
}

pipeline {
    agent none
    stages {
        stage('Build & Test') {
            matrix {
                agent any
                axes {
                    axis {
                        name 'SERVERS'
                        values 'DEV-1', 'TEST-2'
                    }
                    axis {
                        name 'BROWSER'
                        values 'firefox', 'chrome', 'edge'
                    }
                }
                excludes {
                    exclude {
                        axis {
                            name 'SERVERS'
                            values 'DEV-1'
                        }
                        axis {
                            name 'BROWSER'
                            values 'chrome', 'edge'
                        }
                    }
                }
                stages {
                    stage('Build') {
                        steps {
                            echo "Do Build for ${SERVERS} - ${BROWSER}"
                        }
                    }
                    stage('Test') {
                        steps {
                            echo "Do Test for ${SERVERS} - ${BROWSER}"
                        }
                    }
                }
            }
        }
    }
}

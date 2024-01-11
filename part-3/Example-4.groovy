pipeline {
    agent any
    parameters {
        choice(name: 'DEV_DEPLOY', choices: ['Yes', 'No'],
        description: 'Do you want to deploy a development server?')
    }
    stages {
        stage('Compile'){
            steps{
                echo 'build'
                sleep 2
            }
        }
        stage('Test') {
            input {
                message 'Do you want to run tests?'
                ok 'Yes, we should.'
                parameters {
                    choice(
                        name: 'TURN_ON_TEST',
                        choices: ['Yes', 'No']
                    )
                }
            }
            when {
                beforeInput false
                environment name: 'TURN_ON_TEST', value: 'Yes'
            }
            steps {
                echo 'done'
                echo "test $TURN_ON_TEST"
            }
        }
        stage('Deploy to Dev') {
            when {
                environment name: 'DEV_DEPLOY', value: 'Yes'
            }
            steps {
                echo 'Deploying DEPLOY_TO'
            }
        }
    }
}

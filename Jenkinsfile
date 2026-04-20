pipeline {
   agent any;

   environment {
       DOCKERHUB_CREDENTIALS_ID = 'docker_hub'
       DOCKERHUB_REPO = 'blendigr/blendi_test'
       DOCKER_IMAGE_TAG = 'latest'

   }

   stages {

        stage("Checkout") {
            steps{
                 checkout scm
            }
        }

        stage("Build and Test") {
            steps{
                bat "mvn clean install"
            }
        }

        stage("Coverage Report Generation"){
            steps{
                bat "mvn jacoco:report"
            }
        }

        stage("Public Results"){
            steps{
                junit '**/target/surefire-reports/*.xml'
                jacoco()
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    bat "\"${tool 'SonarScanner'}\\bin\\sonar-scanner\""
                }
            }
        }

        stage("Build and Push Docker Image"){
            steps{
                withCredentials([usernamePassword(credentialsId: "${env.DOCKERHUB_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                bat """
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} .
                    docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}
                """
            }}
        }
   }

   post {
       always {
           echo 'Cleaning up Docker resources...'
           bat '''
           docker compose down -v --remove-orphans || exit 0
           docker image prune -f || exit 0
           docker builder prune -f || exit 0
           '''
       }
       success {
           echo 'Pipeline completed successfully! Images pushed to Docker Hub.'
       }
       failure {
           echo 'Pipeline failed.'
           cleanWs()
       }
    }
}
pipeline {
    agent any
	
    environment{
       DOCKER_IMAGE = 'theluigi573/manga_api:latest'
       DOCKER_CREDENTIALS_ID = 'docker-credentials'
       GIT_CREDENTIALS_ID = 'git-credentials'
    }

    stages {
        stage('Build') { 
            steps {
                bat './gradlew clean build' 
            }
        }
	stage('Test') {
            steps {
                bat './gradlew test'
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }
	stage('Build Docker Image') {
            steps {
                script {
                    docker.build(DOCKER_IMAGE)
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
		    docker.withRegistry('', "$DOCKER_CREDENTIALS_ID") {
                         docker.image(DOCKER_IMAGE).push()
                    }
                }
            }
        }
    }
}
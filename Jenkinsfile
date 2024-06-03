pipeline {
    agent any
	
    environment{
       DOCKER_IMAGE = 'theluigi573/manga_api:latest'
       DOCKER_CREDENTIALS_ID = 'dockerhub-credentials'
       GIT_CREDENTIALS_ID = 'git-credentials'
    }

    stages {
        stage('Build') { 
            steps {
                sh 'gradlew clean build' 
            }
        }
	stage('Test') {
            steps {
                sh 'gradlew test'
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
        stage('Commit and Push Changes') {
            steps {
                script {
                    sh 'git config user.name "your-username"'
                    sh 'git config user.email "your-email@example.com"'
                    
                    sh 'git add version.txt'
                    sh 'git commit -m "Update version to ${env.BUILD_NUMBER}"'
                    
                    // Push changes back to the repository
                    withCredentials([usernamePassword(credentialsId: "$GIT_CREDENTIALS_ID", usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
                        sh 'git push https://${GIT_USERNAME}:${GIT_PASSWORD}@your-git-repo-url.git HEAD:main'
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build, Test, and Delivery successful!'
        }
        failure {
            echo 'Build, Test, or Delivery failed!'
        }
    }
}
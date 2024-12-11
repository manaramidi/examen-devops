
pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-ubuntu')  // Remplace 'docker-hub-password' par l'ID des credentials
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Docker Image1') {
            steps {
                script {
                    // Construire l'image Docker
                    sh 'docker build -t manaramidi/image1 .'
                }
            }
        }
        stage('Login to Docker Hub') {
            steps {
                script {
                    // Connexion à Docker Hub avec les credentials
                    withDockerRegistry([credentialsId: 'docker-hub-ubuntu', url: 'https://index.docker.io/v1/']) {
                        echo "Connexion à Docker Hub réussie"
                    }
                }
            }
        }
        stage('Push to Docker Hub') {
            steps {
                script {
                    // Pousser l'image Docker vers Docker Hub
                    withDockerRegistry([credentialsId: 'docker-hub-ubuntu', url: 'https://index.docker.io/v1/']) {
                        sh 'docker push manaramidi/your-image-name'
                    }
                }
            }
        }
    }
}

pipeline {
    agent any
    
    tools {
        // Define o nome da ferramenta Gradle configurada no Jenkins
        gradle 'gradle'
    }

    environment {
        // Especifique as variáveis de ambiente necessárias para autenticação no Docker Hub
        DOCKER_HUB_USERNAME = credentials('dockerhub-username')
        DOCKER_HUB_PASSWORD = credentials('dockerhub-password')
        DOCKER_HUB_EMAIL = '200820@facens.br'
        DOCKER_REPO_NAME = 'joaoferreiradevfacens/2023s2ac2'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Executa a tarefa de build com o Gradle
                    sh "gradle build"
                    sh "newgrp docker"
                    
                    // Constrói a imagem Docker
                    sh "docker build -t ${DOCKER_REPO_NAME}:${DOCKER_IMAGE_TAG} ."
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Executa a tarefa de teste com o Gradle
                    sh "gradle test"
                }
            }
        }
        // stage('Deploy to Docker Hub') {
        //     steps {
        //         script {
        //             // Faz login no Docker Hub
        //             withCredentials([usernamePassword(credentialsId: 'sua-credencial-do-dockerhub-id', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
        //                 sh "docker login -u ${DOCKER_HUB_USERNAME} -p ${DOCKER_HUB_PASSWORD}"
        //             }

        //             // Envia a imagem Docker para o Docker Hub
        //             sh "docker push ${DOCKER_REPO_NAME}:${DOCKER_IMAGE_TAG}"
        //         }
        //     }
        // }
    }
}

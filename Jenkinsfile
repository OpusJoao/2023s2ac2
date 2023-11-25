pipeline {
    agent any
    
    tools {
        // Define o nome da ferramenta Gradle configurada no Jenkins
        gradle 'gradle'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Executa a tarefa de build com o Gradle
                    sh "gradle build"
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
    }
}

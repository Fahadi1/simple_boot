pipeline {
    agent any
    tools {
        maven "M3"
    }
    stages {
        stage("Cleaning workspace") {
            steps {
                sh 'echo "---=--- cleaning stage ---=---"'
                sh 'mvn clean'
                script {
                    try {
                    sh 'docker stop myboot && docker rm myboot'
                    } catch (Exception e) {
                    sh 'echo " ---=--- no container to remove ---=---"'
                    }
                }
            }
        }
        stage("Checkout") {
            steps {
                sh 'echo "---=--- checkout ---=---"'
                git branch: 'master', url:'https://github.com/Fahadi1/simple_boot.git'
            }
        }
        stage("Compile") {
            steps {
                sh 'echo "---=--- compile ---=---"'
                sh 'mvn compile'
            }
        }
        stage("Test") {
            steps {
                sh 'echo "---=--- tests ---=---"'
                sh 'mvn test'
            }
        }
        stage("Package") {
            steps {
                sh 'echo "---=--- package ---=---"'
                sh 'mvn package -DskipTests'
            }
        }
        stage("Docker") {
            steps {
                sh 'echo "---=--- docker ---=---"'
                sh 'docker build -t fahadi1/myboot:1.0 .'
            }
        }
        stage("Deploy to local") {
            steps {
                sh 'echo "---=--- deploy to local ---=---"'
                sh 'docker run -d --name myboot -p 8180:8180 fahadi1/myboot:1.0'
            }
        }
    }
}
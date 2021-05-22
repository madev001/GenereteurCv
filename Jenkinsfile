pipeline {
    agent any
    stages {
        stage('SCM chekout') {
            steps {
      			git branch: 'master', url: 'https://github.com/madev001/GenereteurCv.git'
            }
        }
        
         stage('Maven clean') {
            steps {
                def mvnHome = tool name: 'maven-3.6.3'
    			  bat  "${mvnHome}/bin/mvn clean"
            }
        }
        
        stage('Compile-Package') {
            steps {
                def mvnHome = tool name: 'maven-3.6.3'
    			  bat  "${mvnHome}/bin/mvn package"
            }
        }
        
       
    }
    post {
        
        
        failure {
                  mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "marocoujdamouad@gmail.com";  

        }
    }
}
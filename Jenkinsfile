node{
  stage('SCM chekout'){
    
      git branch: 'master', url: 'https://github.com/madev001/GenereteurCv.git'
  }
    stage('Compile-Package'){
      // Maven home path
      def mvnHome = tool name: 'maven-3.6.3'

      bat  "${mvnHome}/bin/mvn package"
    }
    
    post {  
         always {  
             echo 'This will always run'  
         }  
         success {  
             echo 'This will run only if successful'  
         }  
         failure {  
             mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "foo@foomail.com";  
         }  
         unstable {  
             echo 'This will run only if the run was marked as unstable'  
         }  
         changed {  
             echo 'This will run only if the state of the Pipeline has changed'  
             echo 'For example, if the Pipeline was previously failing but is now successful'  
         }  
     }  
     
  //stage('mail Notification'){
    //mail bcc: '', body: '''Jenkins Alert !
    //Alert!''', cc: '', from: '', replyTo: '', subject: 'Jenkins mail notification', to: 'mouad.alouan@uit.ac.ma'
    
 							//}
}

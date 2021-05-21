node{
  stage('SCM chekout'){
    
      git branch: 'master', url: 'https://github.com/madev001/GenereteurCv.git'
  }
    stage('Compile-Package'){
      // Maven home path
      def mvnHome = tool name: 'maven-3.6.3', type: 'Maven'
      def mvnHomes = tool name: 'maven-3.6.3', type: 'maven'

      bat  "${mvnHome}/bin/mvn package"
    }
    
  stage('mail Notification'){
    mail bcc: '', body: '''Jenkins Alert !
    Alert!''', cc: '', from: '', replyTo: '', subject: 'Jenkins mail notification', to: 'mouad.alouan@uit.ac.ma'
    
 }
}

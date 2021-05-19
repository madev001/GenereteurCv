node{
  stage('SCM chekout'){
    
      git branch: 'master', url: 'https://github.com/madev001/GenereteurCv.git'
  }
    stage('Compile-Package'){
      // Maven home path
<<<<<<< HEAD
      def mvnHome = tool name: 'maven-3.6.3', type: 'Maven'
=======
      def mvnHomes = tool name: 'maven-3.6.3', type: 'maven'
>>>>>>> 61ffad5069e99a303e517bcfe2a5ff34dbca2053

      bat  "${mvnHome}/bin/mvn package"
    }
  stage('mail Notification'){
    mail bcc: '', body: '''Jenkins Alert !!!!
    Alert!''', cc: '', from: '', replyTo: '', subject: 'Jenkins test', to: 'mouad.alouan@uit.ac.ma'
    
 }
}

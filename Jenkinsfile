node {
  stage('Checkout') {
  	checkout scm
  }
  
  stage('Build') {
  	sh "./gradlew clean build"
  }
  
  stage('Distribution') {
  	sh "rm -rf dist"
  	sh "mkdir dist"
  	sh "cp ./modules/algorithm/algorithm-api/build/libs/* ./dist"
  	sh "cp ./modules/algorithm/algorithm-service/build/libs/* ./dist"
  	sh "cp ./modules/custom-login-jsp/build/libs/* ./dist"
  	sh "cp ./modules/custom-login-jsp/build/libs/* ./dist"
  	sh "cp ./modules/guestbook/guestbook-api/build/libs/* ./dist"
  	sh "cp ./modules/guestbook/guestbook-service/build/libs/* ./dist"
  	sh "cp ./modules/guestbook-web/build/libs/* ./dist"
  	sh "cp ./modules/OsgiTutorial/build/libs/* ./dist"
  	sh "cp ./modules/portal-settings-web/build/libs/* ./dist"
  	sh "cp ./modules/user-local-service-override/build/libs/* ./dist"
  	sh "cp ./wars/first-theme/build/libs/* ./dist"
  }

}
pipeline {
    agent any
    stages {
        stage ('SCM checkout'){
            steps{
                retry(3){
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/SupunTJ/3998-jayaweera']])
                }
            }
      
        }
        stage('build docker'){
            steps {
                sh 'docker build -t Supun3998/3998-jayaweera .'
            }
        
        }
         stage('run'){
            steps{
                sh 'docker run -d -p 5000:3000 Supun3998/3998-jayaweera'
         }
         }
         stage('show running containners'){
      steps{
        sh 'docker ps'
      }
    }
    }
}
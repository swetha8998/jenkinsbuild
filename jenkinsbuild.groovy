sh 'docker build -t buildimg .'
sh 'aws ecr-public get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws'
sh 'aws ecr-public create-repository \
     --repository-name build-image \
     --region us-east-1'
sh 'docker tag buildimg:latest public.ecr.aws/registry_alias/build-image'
sh 'docker push public.ecr.aws/registry_alias/build-image'

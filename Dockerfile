name: Docker Image CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

env:
  IMAGE_NAME: your_dockerhub_username/cs333finaldemo:latest

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v2
    - name: Build the Docker image
      run: docker build -t $IMAGE_NAME .
    - name: Login to Docker Hub
      uses: docker/login-action@v1
      with:
        username: ssjlooney
        password: ${{ secrets.dckr_pat_iJfDnu-BDSHwNy7Ux7_ZtN9Ega0 }}
    - name: Push the Docker image
      run: docker push $IMAGE_NAME



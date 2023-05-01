name: Docker Image CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

env:
  IMAGE_NAME: cs333finaldemo

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
        password: dckr_pat_H25OEeye02awxmD7cGnqrcPhi9U
    - name: Push the Docker image
      run: docker push $IMAGE_NAME



# smartix-project
## Installation
You have 2 ways for installation:\
Before running the application, the following commands must be executed in the terminal from the project root directory:
1. Prerequisites for using Dockerfile (recommended)
    1. Install Java 17
    2. Maven 3
    3. Install Docker
    4. run the following command:
```
mvn clean install
docker-compose up
```
2. Prerequisites for using current OS
    1. Install Java 17
    2. Install Postgres sql database
    3. Maven 3
    4. run the following command:
```
mvn clean install
mvn spring-boot:run
```
## Kubernetes configuration
For API scalability, Kubernetes should be installed and submit the yml files that definition to k8s directory with the following command:
```
kubectl apply -f k8s
```
to watch Pods coming alive with:
```
kubectl get pods --watch
```
Finally, for checking application interface, choose one of these solutions:<br/>
* port forward services on current OS and click on the [Link](http://localhost:2022/swagger-ui) after executing command:
    ```
    kubectl port-forward svc/recipes-project 2022:80&    
    ```
* Or get URL of the application service:
    ```
    minikube service service-user --url
    ```
Scaling the application to increase the number of replicas to 3 or more:
```
kubectl scale --replicas=3 deployment/recipes-project
```

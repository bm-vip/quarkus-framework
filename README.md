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
    kubectl port-forward svc/smartix-server 2022:80&    
    ```
* Or get URL of the application service:
    ```
    minikube service service-user --url
    ```
Scaling the application to increase the number of replicas to 3 or more:
```
kubectl scale --replicas=3 deployment/smartix-server
```
# Java Technical Test Task

We at SMART.iX believe that Software Development Craftsmanship is the ultimate skill that our
Software Developers have to master.

In order to produce most reliable, fast and maintainable products we have selected Quarkus (
Supersonic, Subatomic Cloud Native Java Framework) as a foundational technology for our backend
services.

As you are about to join our product development team we want to present you a Technical Test so
that we can better understand what are your skills. Are you ready for it? Let's get started!
You have a chance to receive your first ninja belt.

## Task Definition

Your task it to use [Quarkus](https://quarkus.io/) and [gRPC](https://grpc.io/) to build a
microservice running in [Kubernetes](https://kubernetes.io/) with the following capabilities:

1. The microservice should expose APIs for Smart Models and Smart Features
2. Smart Model is a generic model which can be used to describe your favorite Services and IoT
   Devices. Think about the following examples for

- Devices: Smart Watch, Remotely Controllable Camera, etc
- Services: Open Weather Map, IMDB Movie Database, etc

3. Smart Feature is a specific feature of this smart model which describes one functionality. Please
   consider following examples for:

- Devices: Take Camera Screenshot, Get Camera Live Video URL, Get Calories burned for a day
- Services: Get Weekly Forecast in a City, Get Daily Forecast for a State, Search Movie

4. One Smart Model contains several smart features
5. The microservice should allow storing the smart features and services in a persistent storage and
   retrieving them based on information as name, identifier, type and category.
6. Generate data for a few example Smart Services and Smart Features by yourself for demonstration
   purposes

## General Guidance:

- Think big and start small by creating a common data model which can be applied to both smart
  services and smart models. Keep it simple!
- Framework Usage: Use all the power of Quarkus to deploy your application
- Code Quality: This is your signature, prove us that you are taking care of it
- Unit Tests: They are important for us, please show a good attitude towards them
- Documentation: Provide a short and understandable documentation how:
    - To build the app
    - To deploy the app in minikube or any other Kubernetes local development platform
    - To test the app with simple tools/commands
    - Any other relevant information
- Ensure that application can be built and deployed

## Submitting your project

When you are done, upload your project to GitHub and include a `README.md` file with the
documentation.We will use the project to discuss the technical decisions you make.

When you're done, email us the project link and any additional musings you'd like to share. :)

We will be happy to meet you soon!



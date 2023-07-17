# Spring Boot Email REST API

[![Build Status](https://github.com/Deeksha157/spring-email/workflows/Build/badge.svg)](https://github.com/<username>/<repository>/actions)

A sample Spring Boot REST API project that demonstrates sending emails. This project utilizes Maven as the build tool, Docker for containerization, Kubernetes for deployment, and GitHub Actions for continuous integration.

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Apache Maven
- Docker
- Kubernetes cluster (if deploying to K8s)
- Gmail account, with app passwords, [link to Google Help](https://support.google.com/accounts/answer/185833?hl=en)

## Getting Started

Follow these steps to get the project up and running on your local machine.

1. Clone the repository:

   ```bash
   git clone https://github.com/Deeksha157/spring-email.git
   
2. Build the project using Maven:
    
    ```bash
    cd spring-email
    mvn clean package
   
3. Set required environment variables, for windows use [Microsoft documentation](https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/set_1) to set the environment variables.

    ```bash
   export GMAIL_USERNAME="<your_gmail_id>"
   export GMAIL_PWD="<your_gmail_app_password>"

4. Run the application:

    ```bash
   java -jar target/spring-email-0.0.1-SNAPSHOT.jar
   
5. Test the API endpoints using a tool like cURL or Postman.

## Docker

1. To containerize the application with Docker, use the following steps:

    ```bash
    docker build --build-arg JAR_FILE=target/*.jar -t <image-name>:<tag> .
   
2. Run the Docker container:
   
    ```bash
    docker run -p 8080:8080 <image-name>:<tag> -e GMAIL_USERNAME="<your_gmail_id>" -e GMAIL_PWD="<your_gmail_app_password>"
   
3. Access the API at http://localhost:8080 and OpenAPI documentation at http://localhost:8080/swagger-ui

## Kubernetes

To deploy the application to a Kubernetes cluster, follow these steps:

1. Modify the `devops/deployment.yaml` file with your desired configurations.

2. Apply the Kubernetes manifest:

   ```bash
   kubectl apply -f ./devops/deployment.yaml
   
3. Verify the deployment:

   ```bash
   kubectl get pods
   
4. If required, access the API using the exposed service.

   ```bash
   kubectl apply -f ./devops/service.yml

## Continuous Integration (CI) with GitHub Actions

This repository is configured with GitHub Actions to automatically build and test the application on every push. The workflow file is located at `.github/workflows/build.yml`.

You can check the build status and details in the Actions tab of this repository.

## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvements, please create an issue or submit a pull request.

## License

This project is licensed under the [MIT License](https://en.wikipedia.org/wiki/MIT_License).
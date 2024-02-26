
## Spring Boot Email API

**This is a Spring Boot application that provides an API for sending emails with dynamic content.**

### Features

-   **Email Sending:**
    -   Send emails using MimeMessage objects with customizable content.
    -   Integrate with various email providers through configuration.
-   **Templating:**
    -   Use Thymeleaf templates to dynamically generate email content.
-   **Logging:**
    -   Utilize Logback for comprehensive application logging.
-   **Data Validation:**
    -   Implement global controller advice to handle and return appropriate responses for incorrect data submitted to the API.
-   **Annotations:**
    -   Leverage Lombok annotations for improved code readability and maintainability.

### Prerequisites

-   Java JDK
-   Git

### Dependencies

-   Spring Boot
-   Gradle
-   Thymeleaf
-   Logback
-   Java Mail API
-   Lombok (optional)

### Installation

1.  **Clone the repository:**

```
git clone https://github.com/Faizan1203/portfolio-backend.git

```

2.  **Install dependencies:**

```
./gradlew build

```

3.  **Configure email settings:**

-   Update the  `application.properties`  file with your email provider configuration details, such as SMTP server details, username, and password. You can obtain the steps to retrieve them from [here](https://support.google.com/a/answer/176600?hl=en).

4.  **Run the application:**

```
./gradlew bootRun

```

## Running the Application with Docker Compose (Optional)

**Prerequisites:**

-   **Docker:**  [https://www.docker.com/](https://www.docker.com/)
-   **Docker Compose:**  [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)

**1. Update `docker-compose.yml`:**

In the `docker-compose.yml` file, locate the `portfolio-backend` service and add the following environment variables:

YAML

```
environment:
  SPRING_MAIL_USERNAME: <your-email>
  SPRING_MAIL_PASSWORD: <your-email-password>

```


Replace `<your-email>` and `<your-email-password>` with your actual credentials.

**2. Run the Application:**

Open your terminal and navigate to the directory containing the `docker-compose.yml` file. Then, run the following command:

Bash

```
docker-compose up -d

```


This builds the container image and starts the service in the background.

**3. Access the Application:**

Once the container is running, you can hit the API using the example request from the usage section below.

**Note:**

-   Store sensitive information like passwords securely.

For more details, refer to the official Docker Compose documentation: [https://docs.docker.com/compose/](https://docs.docker.com/compose/).

**### Usage**

**Sending a Contact Form Submission**

To send an email using the API, make a POST request to the `/sendMail` endpoint with a JSON payload containing the following fields:

-   `firstName`: The sender's first name (required)
-   `lastName`: The sender's last name (required)
-   `email`: The sender's email address (required, valid email format)
-   `subject`: The email subject (required)
-   `message`: The email message body (required)

**Example Request**

Bash

```
curl -X POST -H "Content-Type: application/json" -d '{"firstName": "John", "lastName": "Doe", "email": "johndoe@example.com", "subject": "Test Email", "message": "This is a test message."}' http://localhost:8080/sendMail

```



**Response**

Upon successful email submission, the API will return a string containing a success message, usually from your configured email service:

```
Email sent successfully.

```

**Error Handling**

The API includes validation to ensure required fields are present and the email address is valid. If any validation errors occur, the API will return a JSON response with a specific error message, such as:

JSON

```
{
  "firstName": "First Name is required"
}

```


**Integration with Frontend**

To seamlessly integrate this API with a frontend application, create a form that collects the necessary fields and triggers a POST request to the `/sendMail` endpoint with the collected data in JSON format. This API was designed to be used in coordination with [this](https://github.com/Faizan1203/portfolio-frontend) frontend portofolio. You can refer to the repo if you wanted some inspiration on frontend ideas :smiley:.

### Additional Notes

-   This project uses global controller advice to handle invalid data sent to the API. You can customize the error handling behavior as needed.
-   Consider using an environment variable management tool to securely store sensitive information like email credentials.

### Contributing

**Feel free to fork the repository and submit pull requests with your contributions.**

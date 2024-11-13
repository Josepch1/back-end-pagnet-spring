# Back-end Pagnet Spring Project

Welcome to the **Back-end Pagnet Spring Project**! This project is built using Spring Boot and Spring Batch to handle background jobs efficiently. 🚀

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)

## Introduction

This project is designed to process CNAB files using Spring Batch. It reads, processes, and writes transaction data to a database, ensuring efficient and reliable background job execution.

## Features

- 📂 **File Upload**: Upload CNAB files for processing.
- ⚙️ **Batch Processing**: Efficiently process large amounts of data using Spring Batch.
- 🗄️ **Database Integration**: Store processed transaction data in a database.
- 🛠️ **Configurable**: Easily configure file upload directory and other settings.

## Getting Started

### Prerequisites

- Java 23 or higher
- Maven 3.6.5 or higher

### Installation

1. Clone the repository:

  ```sh
  git clone https://github.com/Josepch1/back-end-pagnet-spring.git
  cd back-end-pagnet-spring
  ```

2. Build the project:

  ```sh
  ./mvnw clean package
  ```

3. Run the application:

  ```sh
  java -jar target/backend-0.0.1-SNAPSHOT.jar
  ```

## Usage

1. Insert the CNAB files into **files/** folder:

2. The file will be processed in the background, and the transaction data will be stored in the database.

Happy coding! 😊

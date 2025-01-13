# my-helloworld-GH-Actions

#!/bin/bash

# Update the system
echo "Updating the system..."
sudo apt update -y

# Install Java (OpenJDK 11)
echo "Installing OpenJDK 11..."
sudo apt install openjdk-11-jdk -y

# Verify Java Installation
echo "Verifying Java installation..."
java -version

# Install Maven
echo "Installing Apache Maven..."
# Install required dependencies for Maven
sudo apt install wget -y

# Download and install Apache Maven
MAVEN_VERSION="3.8.4"
wget https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz

# Extract and install Maven
tar -xvzf apache-maven-${MAVEN_VERSION}-bin.tar.gz
sudo mv apache-maven-${MAVEN_VERSION} /opt/maven

# Set up Maven environment variables
echo "Setting up Maven environment variables..."
echo "export M2_HOME=/opt/maven" >> ~/.bashrc
echo "export MAVEN_HOME=/opt/maven" >> ~/.bashrc
echo "export PATH=\$MAVEN_HOME/bin:\$PATH" >> ~/.bashrc

# Reload the .bashrc file to apply changes
source ~/.bashrc

# Verify Maven installation
echo "Verifying Maven installation..."
mvn -version

echo "Java and Maven installation completed successfully."

========================================================================================================================================================================
Access Your Servlet on tomcat
Open your web browser and go to http://<EC2-PUBLIC-IP>:8080/my-helloworld/helloWorld to access your servlet.

You can test it by adding the error=true query parameter to see the error handling in action, e.g., http://<EC2-PUBLIC-IP>:8080/my-helloworld/helloWorld?error=true.



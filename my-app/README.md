# mavenDemo
This is a demo project created to demonstrate how maven works and why do we need separate modules in our project.

## What is Maven?

Maven is a powerful build automation and dependency management tool primarily used in Java projects. It simplifies the build process, dependency resolution, and project management. Maven uses an XML file called `pom.xml` (Project Object Model) to define project configurations, dependencies, plugins, and build lifecycle.

### Key Features of Maven:
- **Dependency Management**: Automates the inclusion of required libraries and handles their transitive dependencies.
- **Build Automation**: Provides a standardized build process with predefined lifecycle phases such as `compile`, `test`, and `package`.
- **Multi-Module Projects**: Allows managing multiple related modules within a single project.
- **Plugins and Customization**: Extensible through plugins for additional functionality.
- **Central Repository**: Maven downloads dependencies from online repositories, reducing the need to manually include JAR files.

---

## How Does Maven Work?

Maven operates based on a build lifecycle, consisting of three main lifecycles:
1. **Default Lifecycle**: Handles project build and deployment.
2. **Clean Lifecycle**: Cleans the project by removing temporary or previous build files.
3. **Site Lifecycle**: Generates documentation and reports.

Each lifecycle consists of specific phases. For example, in the default lifecycle:
- `validate`: Validates the project structure and configuration.
- `compile`: Compiles source code.
- `test`: Runs unit tests.
- `package`: Packages the compiled code into a distributable format (e.g., JAR or WAR).
- `install`: Installs the package into the local repository.
- `deploy`: Deploys the project to a remote repository.

Maven simplifies project management by automatically resolving dependencies and ensuring consistency across builds.

---

## Maven in This Project

This project is a demonstration of Maven’s multi-module capabilities, dependency management, and build lifecycle.

### Project Structure

- **Parent Project (`my-app`)**:
  - Serves as the root module.
  - Contains the main `pom.xml` file to define shared dependencies and module configuration.
- **Modules**:
  - `module_1`: A library module providing reusable functionality (e.g., `Module1Class`).
  - `module_2`: A consumer module using functionality provided by `module_1`.

### How Maven is Used Here:

1. **Dependency Management**:
   - `module_2` depends on `module_1`. Maven resolves this dependency using the `pom.xml` configuration in `module_2`.
   - External dependencies like JUnit (for testing) and Gson (for JSON processing) are declared in the parent `pom.xml` file and managed by Maven.

2. **Multi-Module Management**:
   - The parent `pom.xml` lists `module_1` and `module_2` under the `<modules>` tag.
   - Maven builds all modules in a single command, ensuring inter-module dependencies are resolved automatically.

3. **Build Lifecycle**:
   - Running `mvn clean install` executes the entire build lifecycle:
     - Cleans previous build artifacts.
     - Compiles the source code for both modules.
     - Packages `module_1` as a JAR file and uses it in `module_2`.
     - Installs the final output in the local Maven repository.

### Why Maven is Important for This Project:

- **Consistency**: Ensures all developers and environments use the same dependencies and build process.
- **Modularity**: Simplifies the management of a multi-module project by automating inter-module dependencies.
- **Automation**: Eliminates manual steps in compiling, packaging, and managing libraries.
- **Reusability**: Allows the code from `module_1` to be easily shared and reused by `module_2` or other projects.
- **Scalability**: Makes it easier to scale the project with additional modules and dependencies without complicating the build process.

---

## How to Use Maven in This Project

1. **Build the Project**:
   - Navigate to the parent project directory (`my-app`) and run:
     ```sh
     mvn clean install
     ```

2. **Run the Application**:
   - Navigate to the `module_2` directory:
     ```sh
     cd module_2
     ```
   - Execute the main class:
     ```sh
     java -cp target/module_2-1.0-SNAPSHOT.jar Module2Class
     ```

3. **Adding New Dependencies**:
   - Update the appropriate `pom.xml` file to include the dependency under the `<dependencies>` tag.
   - Run `mvn clean install` to download and include the dependency in the build process.

4. **Adding a New Module**:
   - Create a new directory for the module (e.g., `module_3`).
   - Add a `pom.xml` file to the new module and declare it in the parent `pom.xml` under the `<modules>` section.
   - Implement the functionality, declare dependencies, and build the project using Maven.

---

## Conclusion

This project demonstrates Maven’s capabilities to streamline development in a multi-module Java project. By automating dependency resolution, enforcing a standardized build process, and enabling modular development, Maven significantly enhances project scalability, maintainability, and developer productivity.


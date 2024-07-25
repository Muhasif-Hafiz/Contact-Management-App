# Contact-Management-App
# ContactsMania

ContactsMania is an Android application that allows users to log in and manage their contacts. The app is built using Kotlin and integrates with Firebase Realtime Database to store and retrieve contact information.

## Features

- User login with phone number.
- Add and save contacts under a specific user node.
- Display a welcome message to the user upon login.
- User-friendly UI with dialog prompts for successful operations.

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/ContactsMania.git
    ```

2. Open the project in Android Studio.

3. Make sure you have the following dependencies in your `build.gradle` files:

    ```gradle
    // Project-level build.gradle
    buildscript {
        dependencies {
            classpath 'com.google.gms:google-services:4.3.10'
        }
    }

    // App-level build.gradle
    dependencies {
        implementation 'com.google.firebase:firebase-database:20.0.5'
        implementation 'com.google.android.material:material:1.4.0'
        implementation 'androidx.appcompat:appcompat:1.3.1'
        implementation 'androidx.core:core-ktx:1.6.0'
        implementation 'androidx.activity:activity-ktx:1.3.1'
    }
    apply plugin: 'com.google.gms.google-services'
    ```

4. Sync the project with Gradle files.

5. Configure Firebase:
    - Go to the Firebase Console.
    - Create a new project or use an existing project.
    - Add an Android app to your Firebase project.
    - Download the `google-services.json` file.
    - Place the `google-services.json` file in the `app` directory of your project.

6. Build and run the app on your Android device or emulator.

## Usage

1. **Log In:**
    - Open the app and enter your phone number in the login screen.
    - Click on the "Sign In" button.

2. **Add Contacts:**
    - After logging in, you will see a welcome message.
    - Enter the contact name and contact number.
    - Click on the "Add" button to save the contact.
    - A dialog will appear confirming the successful addition of the contact.

## Project Structure

- `LogInActivity.kt`: Handles user login functionality.
- `contactsScreen.kt`: Allows users to add and save contacts.
- `activity_log_in.xml`: Layout for the login screen.
- `activity_contacts_screen.xml`: Layout for the contacts screen.
- `dialoglayout.xml`: Layout for the confirmation dialog.

## Screenshots

![Login Screen](screenshots/login_screen.png)
![Contacts Screen](screenshots/contacts_screen.png)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/fooBar`).
3. Commit your changes (`git commit -am 'Add some fooBar'`).
4. Push to the branch (`git push origin feature/fooBar`).
5. Create a new Pull Request.

## Contact

For any inquiries or issues, please reach out to [your-email@example.com](mailto:your-email@example.com).

---

Happy Coding!

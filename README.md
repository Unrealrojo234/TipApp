# Tip Calculator App

## Overview

The **Tip Calculator** is a simple Android application built using Jetpack Compose. It allows users to calculate the tip amount based on the bill amount and the desired tip percentage. The app also includes an option to round up the tip amount for convenience.

## Features

- **Bill Amount Input**: Enter the total bill amount.
- **Tip Percentage Input**: Specify the desired tip percentage.
- **Round Up Option**: Toggle to round up the calculated tip amount.
- **Error Handling**: Validates input to ensure valid and positive numbers are entered.
- **Responsive UI**: Built with Jetpack Compose for a modern and responsive user interface.

## Screenshots

<img src="https://github.com/user-attachments/assets/81d66ec1-5b1e-4945-91d4-c07a4823fe81" width="400"/>
&nbsp;
<img src="https://github.com/user-attachments/assets/3e893218-18fd-4e75-8f70-847488e85ea7" width="400" />

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Unrealrojo234/TipApp
   ```

2. **Open the Project**:
   - Open Android Studio.
   - Select `Open an existing Android Studio project`.
   - Navigate to the cloned repository and select the `tip-calculator` folder.

3. **Run the App**:
   - Connect an Android device or start an emulator.
   - Click on the `Run` button in Android Studio to build and run the app.

## Usage

1. **Enter Bill Amount**:
   - Input the total bill amount in the provided field.

2. **Enter Tip Percentage**:
   - Specify the desired tip percentage.

3. **Round Up Tip (Optional)**:
   - Toggle the switch to round up the tip amount if desired.

4. **Calculate Tip**:
   - Press the `Calculate` button to compute the tip amount.

5. **View Result**:
   - The calculated tip amount will be displayed below the button.

## Code Structure

- **MainActivity.kt**: The main activity that sets up the UI using Jetpack Compose.
- **Tip.kt**: The composable function that defines the UI and logic for the tip calculator.

### Key Components

- **OutlinedTextField**: Used for input fields for bill amount and tip percentage.
- **Switch**: Allows users to toggle the round-up option.
- **Card**: Used to group and style UI elements.
- **Button**: Triggers the tip calculation.
- **Text**: Displays the calculated tip amount and error messages.

## Dependencies

- **Jetpack Compose**: Modern UI toolkit for building native Android UI.
- **Material Design**: Provides Material Design components and theming.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeatureName`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeatureName`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Jetpack Compose documentation.
- Android Developers community.

## Contact

For any questions or feedback, please contact [otienoryan812@gmail.com](mailto:otienoryan812@gmail.com).

---

Enjoy calculating your tips with ease! 🎉

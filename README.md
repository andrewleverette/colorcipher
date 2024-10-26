# ColorCipher

A command-line implementation of the classic game  *MasterMind* in Clojure.

## Objectives

1. Develop familiarity with core Clojure syntax, immutable data structures, and functional programming paradigms.
2. Gain experience with state management, user input handling, and feedback mechanisms.
3. Implement logic for a complete game loop, enabling users to play multiple rounds in a REPL-driven, interactive setup.
4. Manage game state in a functional style, updating attempts, feedback, and guesses through immutable transformations.

---

## Functional Requirements

1. **Game Initialization:**
	- The computer randomly selects a solution sequence of four colors from a predefined color set.
	- The solution should be stored in the game state and remain hidden from the player.
2. **Player Guesses and Feedback:**
	- Players enter guesses as a sequence of four colors from the color set.
	- For each guess, provide feedback:
		- **Black Pegs**: Count for each color in the correct position.
		- **White Pegs**: Count for each correct color in an incorrect position.
	- Display feedback after each guess, including the number of black and white pegs.
3. **Game State Management:**
	- Track the number of remaining guesses and maintain a history of past attempts.
	- Update the game state after each guess, including feedback and the remaining guess count.
	- End the game when the player guesses correctly or uses up all attempts.
4. **User Input and Output:**
	- Handle player input for guesses and validate them to ensure they are a valid sequence of colors.
	- Provide feedback on invalid input and request a new guess.
	- Display messages indicating whether the player has won, lost, or should try again based on game state.
5. **REPL as Game Interface:**
	- The game runs interactively in the REPL, allowing players to enter guesses and see feedback until the game ends.
	- On game completion, allow the user to start a new game or quit.
6. **(Stretch Goal) Customization and Difficulty Levels:**
	- Allow players to select difficulty levels, altering the number of colors in the solution or the length of the sequence.
	- Implement additional customization options like increasing or decreasing the number of guesses available.

---

## Non-Functional Requirements

1. **User Interface:** 
   - Provide a simple command-line interface to interact with the game in the REPL.
   - Keep the interface user-friendly, with clear instructions and feedback messages.
2. **Error Handling:** 
   - Ensure graceful handling of invalid inputs, with appropriate error messages.
   - Validate input to check if the guess contains only valid colors and has the correct length.
3. **Project Structure:** 
   - Maintain a modular project structure, organizing game logic, feedback mechanisms, and user interaction separately.

---

## Testing

1. **Unit Testing:**
	- Test functions responsible for feedback calculations and validating correct counts for black and white pegs.
	- Test the solution generation to ensure valid and varied outputs.
2. **Integration Testing:**
	- Test the main game loop for continuous operation, including tracking the state of attempts and game-ending conditions.
3. **Edge Case Handling:**
	- Ensure that the game handles edge cases gracefully, such as invalid inputs, guesses of the wrong length, and unexpected symbols.
	
---

## Future Enhancements

1. **Web Interface:** Develop a web-based version using ClojureScript or a web framework to create a graphical interface for easier interaction.
2. **Game History Tracking:** Add functionality to display past games and guesses for players to review their strategy and outcomes.
3. **Multi-Player Mode:** Implement a multiplayer version where players take turns guessing, with feedback and score tracking.

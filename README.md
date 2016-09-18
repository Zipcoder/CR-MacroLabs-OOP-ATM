# project-2-ATM
Week 2 project: ATM Simulator

## ATM Requirements

Every feature must have corresponding unit tests
Tests should demonstrate proper behavior, and proper handling of misuse (eg attempts to deposit/transfer/withdraw negative amounts

- User interface: CLI Only
  - Direct Input
  - Numbered options (instead of on-screen buttons)
  - ASCII art welcome but not required
- Must support account types:
  - Checking
  - Savings
  - Investment
- Account Actions
  - Withdraw from acct
  - Deposit to acct
  - Transfer across accounts (self)
  - Open new account
  - Close account (must be empty)
  - Print transaction history
  - Check balance
  - **Challenge:** Transfer to another user's account (but not from)
- Support multiple users
  - Users have associated accounts
  - Can create new user
  - Users are authenticated with a password (generated or provided on user creation)
  - Can exit a user and enter another user
- **BONUS** Persistence
  - Users and accounts remain persistent
  - Opportunity for research

Recommended:

Create a `UserInputHandler` class that manages all input requests to the user; Extend this with a `DummyUserInputHandler` for testing (provide scripted user input using this object)


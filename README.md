# ms-account-service

---
## Endpoints

A banking application


| # | Operation                              | Description                      | Full Endpoint                                            |
|---|----------------------------------------|----------------------------------|----------------------------------------------------------|
| 1 | GET /account/                          | List all Accounts                     | http://localhost:9193/v1/account/                        |
| 2 | POST /account/                         | Create an account                | http://localhost:9193/v1/account/                        |
| 3 | GET /account/{accountNumber}           | Find an account by accountNumber | http://localhost:9193/v1/account/{accountNumber}         |
| 4 | PUT /account/{accountNumber}           | Activate /Deactivate an account | http://localhost:9193/v1/account/{accountNumber}         |
| 5 | POST /account/deposit/{accountNumber}  | Deposit to an account        | http://localhost:9193/v1/account/deposit/{accountNumber} |
| 6 | POST /account/withdraw/{accountNumber} | Withdraw from an account              | http://localhost:9193/v1/account/withdraw/{accountNumber} |  

## Logging
Logs are created in the /logs folder

### 1. List All account

Retrieves all account within the banking system

![](/home/ba/IdeaProjects/ms-account-service/src/main/resources/images/ListAllAccount.png)

### 2. Create an account

This API creates an account with the following as inputs:

`accountName`: Name of the account holder

`currency`: 3 letter [ISO Code](https://en.wikipedia.org/wiki/ISO_4217) of the currency

`currentBalance`: BY default an account's balance is set to zero. Its after creation that a deposit can be made.

**NB**: Account number will be generated automatically by the system and doesn't need to be generated withing the request body to avoid conflicts. 

![](/home/ba/IdeaProjects/ms-account-service/src/main/resources/images/CreateAccount.png)

### 3. Find an account by accountNumber 

Retrieve account details

![](/home/ba/IdeaProjects/ms-account-service/src/main/resources/images/FindAccountByAccNumber.png)

### 4. Activate /Deactivate an account

Activate or deactivate an account

![](/home/ba/IdeaProjects/ms-account-service/src/main/resources/images/Activate_Deactivate.png)

### 5. Deposit to an account 

Deposit money to an account

![](/home/ba/IdeaProjects/ms-account-service/src/main/resources/images/Deposit.png)

### 6. Withdraw from an account

Withdraw funds from an account

![](/home/ba/IdeaProjects/ms-account-service/src/main/resources/images/Withdraw.png)
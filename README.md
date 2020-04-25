# README

## Current Pages

All pages have a home button in the top left that takes users back to the Main Page (excludes Main Page)

### Main

1. Start

** Takes User to User Profile Page

2. About HUD 

** Takes User to About Page

3. Test Data

** Takes User to Test Data Page

4. Test Alarm

** Button toggles test alarm

### User Profile
1. User Name
** User input (string)
2. Age
** User input (numbers)
3. Sex 
** User input (switch)
4. Save User
** Passes user information to confirmation page

### View User Profile
1. Name
2. Age
3. Sex
4. Confirm User Info
** Brings user to Connecting to Wheel Page

### Connecting to Wheel
1. Make Device Available
** First step to make device available via bluetooth
2. Search for Device
** Second Step to find device to connect to
** Select pairing device
3. Connect to Wheel
** Creates the connection

4. Functionality to test bluetooth connection available.  Enter Data and select Send.  Logfile for each device should show input and output streams (ie messages received and sent).

### About HUD
1. Short description of the desired use of product

### Test Data
* Four buttons to test data
* Data comes in .csv files filled with R-R intervals located in the raw folder
* First three buttons run single test files specified in java code
* Fourth button runs three test files each with 90 different combinations of threshold values, LP filter values, pNN values, and window sizes
** Total of 270 files
** Threshold Values: 5, 10, 20, 25
** LP Filter Values: 20, 25, 30
** pNN Values: 30, 50
** Window Sizes: 50, 100, 200
* All decisions are outputted to a .csv file that is saved to the Android phone's internal storage

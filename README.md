# Alovoa

Support us on Kickstarter! https://www.kickstarter.com/projects/nonononoki/alovoa-the-private-dating-app-for-you

Alovoa aims to be the first widespread open-source dating web application on the web. What differs this from other platform?
- No ads
- No selling your data
- No paid features (no "pay super-likes", "pay to swipe", "pay to view profile" or "pay to start a chat")
- No unsecure servers
- No closed-source libraries
- No seeing people you don't want to see
- Encrypting your most private data

### How to build:
- Install a JDK (OpenJDK 8 is officially supported)
- Install maven: https://maven.apache.org/install.html
- Setup a database (MariaDB is officially supported)
- Setup an email server or use an existing one (any provider with IMAP support should work)
- Enter credentials for database server, email server and encryption keys in application.properties
- Execute "mvn install" in the folder where the pom.xml resides.

### Licenses:
- All code not otherwise stated is licensed under the AGPLv3 license. 
- Images (except the official logo, which is still WIP) are public domain.
- Third-party web libraries can be found under resources/css/lib and resources/js/lib and have their own license.
- Third-party Java libraries can be found in the pom.xml and have their own license.

### Note:
- Pull requests are not currently accepted, as it's still in early development. Suggestions are always welcome!

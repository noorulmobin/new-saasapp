# Hello World Node.js App

A simple Node.js Hello World application with TeamCity CI/CD pipeline configuration.

## What it does

- Simple Express.js server
- Returns "Hello World" message
- Health check endpoint
- Docker containerization

## Quick Start

### Local Development
```bash
# Install dependencies
npm install

# Run the app
npm start

# Or run with nodemon for development
npm run dev
```

### Docker
```bash
# Build image
docker build -t hello-world-app .

# Run container
docker run -p 3000:3000 hello-world-app

# Access at http://localhost:3000
```

## API Endpoints

- `GET /` - Hello World message
- `GET /health` - Health check

## TeamCity Setup

1. **Push to GitHub**
   ```bash
   git add .
   git commit -m "Initial commit"
   git push origin main
   ```

2. **In TeamCity**
   - Create new project
   - Import the `ci/teamcity/build-config.kts` file
   - Update the Git repository URL in the config
   - Run the build

## Project Structure
```
├── app.js                 # Main application
├── package.json          # Dependencies
├── Dockerfile            # Docker configuration
├── ci/
│   └── teamcity/
│       └── build-config.kts  # TeamCity pipeline
└── README.md
```

That's it! Simple Hello World app with TeamCity CI/CD pipeline. 
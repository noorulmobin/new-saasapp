#!/bin/bash

echo "🚀 Setting up Hello World Node.js App..."

# Install dependencies
echo "📦 Installing dependencies..."
npm install

# Test the app
echo "🧪 Testing the app..."
npm test

# Build Docker image
echo "🐳 Building Docker image..."
docker build -t hello-world-app .

echo "✅ Setup complete!"
echo ""
echo "To run the app locally:"
echo "  npm start"
echo ""
echo "To run with Docker:"
echo "  docker run -p 3000:3000 hello-world-app"
echo ""
echo "To push to GitHub:"
echo "  git add ."
echo "  git commit -m 'Initial commit'"
echo "  git push origin main"
echo ""
echo "Then import ci/teamcity/build-config.kts into TeamCity!" 
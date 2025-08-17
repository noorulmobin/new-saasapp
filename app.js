#!/usr/bin/env node
/**
 * Hello World Application
 * Part of Configuration-as-Code Demo
 * 
 * This application demonstrates:
 * - Basic Express.js setup
 * - Multiple API endpoints
 * - Environment variable usage
 * - Health checks
 * - Security headers
 * - Logging
 */

const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req, res) => {
  res.json({
    message: 'Hello World from Node.js!',
    timestamp: new Date().toISOString(),
    service: 'hello-world-app'
  });
});

app.get('/health', (req, res) => {
  res.json({
    status: 'healthy',
    timestamp: new Date().toISOString()
  });
});

app.listen(PORT, () => {
  console.log(`🚀 Hello World app running on port ${PORT}`);
}); 
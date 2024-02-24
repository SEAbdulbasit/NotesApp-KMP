const path = require('path');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
    entry: './src/index.js',
    output: {
        filename: 'main.js',
        path: path.resolve(__dirname, 'dist'),
    },
    plugins: [
        new CleanWebpackPlugin(),
    ],
    resolve: {
        fallback: {
            "crypto": require.resolve("crypto-browserify"),
            "path": require.resolve("path-browserify"),
            "fs": require.resolve("fs-extra"),
        }
    },
};
import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    port: 3000,
    proxy: {
      '/api': {
        target: "http://127.0.0.1:8080", // 动态设置目标服务器地址
        changeOrigin: true,
        rewrite(path) {
          return path.replace(/^\/api/, ''); // 移除路径中的 /api 前缀
        },
        secure: false
      }
    }

  },
})

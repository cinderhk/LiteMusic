import { fileURLToPath, URL } from 'node:url';
import { defineConfig,loadEnv } from 'vite';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/
export default defineConfig(({ command, mode }) => {
  // 加载环境变量
  const env = loadEnv(mode, process.cwd(), '');

  return {
    plugins: [
      vue(),
    ],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url)),
      },
    },
    server: {
      port: 3000,
      proxy: {
        '/api': {
          target: env.VITE_APP_DEV_API, // 设置目标服务器地址
          changeOrigin: true,
          rewrite(path) {
            return path.replace(/^\/api/, ''); // 移除路径中的 /api 前缀
          },
          secure: false,
        },
      },
    },
  };
});
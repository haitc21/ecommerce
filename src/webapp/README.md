1. Tạo alias import

- Install [craco](https://github.com/dilanx/craco)

``` cmd
npm i -D @craco/craco
```

- Trong tsconfig.ts thêm path trong compilerOptions
- Tạo file craco.config trong thư mục chính
- Sửa phần "script" trong package.json

2. Cấu hình Prettier - Code formatter

- Dùng để format code
- Install Extenssion tên là formatter trong VS Code
- Tạo file .prettierrc

``` .prettierrc
{
    "arrowParens": "always",
    "bracketSameLine": false,
    "bracketSpacing": true,
    "embeddedLanguageFormatting": "auto",
    "htmlWhitespaceSensitivity": "css",
    "insertPragma": false,
    "jsxSingleQuote": false,
    "printWidth": 120,
    "proseWrap": "preserve",
    "quoteProps": "as-needed",
    "requirePragma": false,
    "semi": true,
    "singleQuote": true,
    "tabWidth": 4,
    "trailingComma": "all",
    "useTabs": false,
    "vueIndentScriptAndStyle": false
}
```

- Tạo file .vscode/settings.json

``` settings.json
{
    "editor.formatOnSave": true,
    "editor.defaultFormatter": "esbenp.prettier-vscode"
}
```

3. Cấu hình sass

``` cmd
npm i -D sass
```

- Cài đặt nomalize.css

``` cmd
npm i normalize.css
```

4. Cài đặt Tailwind

- [Tailwind](https://tailwindcss.com/docs/guides/create-react-app)

4. Cài đặt Material UI

- [Cấu hình typescript](https://mui.com/material-ui/guides/typescript/)
- Install

``` cmd
npm install @mui/material @emotion/react @emotion/styled
```

5. Icon

``` cmd
npm install @mui/icons-material heroicons
npm install @heroicons/react
```

6. Headlessui

``` cmd
npm install @headlessui/react
```

7. react-alice-carousel

- [Github](https://github.com/maxmarinich/react-alice-carousel)

``` cmd
npm i react-alice-carousel
```

8. react-router-dom

```cmd
 npm i react-router-dom
 ```

 9. Redux

- Cách cũ

 ``` cmd
 npm i redux redux-thunk react-redux
 ```

- Cách mới

``` cmd
npm install @reduxjs/toolkit react-redux
```

- Cài đặt [Redux DevTools](https://microsoftedge.microsoft.com/addons/detail/redux-devtools/nnkgneoiohoecpdiaponcejilbhhikei)
- [doc](https://github.com/reduxjs/redux-devtools/tree/main/extension#installation)

 10. Axios

 ``` cmd
npm i axios
 ```

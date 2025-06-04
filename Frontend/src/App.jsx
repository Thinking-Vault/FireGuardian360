import React from 'react';
import './App.css'
import {AlertList} from "./components/AlertList.jsx";
import {Checklist} from "./components/Checklist.jsx";

export default function App() {
    const lat=-23.55, lng=-46.63, userId=1;
    return (
        <div>
            <h1>FireGuardian360</h1>
            <AlertList lat={lat} lng={lng} />
            <Checklist userId={userId} />
        </div>
    );
}

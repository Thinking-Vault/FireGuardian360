import React from 'react';
import './App.css'
import { AlertList } from "./components/AlertList.jsx";
import { Checklist } from "./components/Checklist.jsx";
import PsyHelp from "./pages/PsyHelp.jsx";

export default function App() {
    const lat = -23.55, lng = -46.63, userId = 1;
    return (
        <div>
            <h1>FireGuardian360</h1>
            <AlertList lat={lat} lng={lng} />
            <Checklist userId={userId} />
            {/* <PsyHelp userId={userId} /> */}
        </div>
    );
}



















// import React from 'react';
// import './App.css'
// import {AlertList} from "./components/AlertList.jsx";
// import {Checklist} from "./components/Checklist.jsx";
// import Shelter from './pages/Shelter.jsx';
// import Alert from './pages/Alert.jsx';
// import PsyHelp from "./pages/PsyHelp.jsx";

// export default function App() {
//     const lat=-23.55, lng=-46.63, userId=1;
//     return (
//         <div>
//             <h1>FireGuardian360</h1>
//             <AlertList lat={lat} lng={lng} />
//             <Checklist userId={userId} />
//             {/* <Shelter lat={lat} lng={lng} />
//             <PsyHelp userId={userId} />
//             <Alert lat={lat} lng={lng} /> */}

//         </div>
//     );
// }

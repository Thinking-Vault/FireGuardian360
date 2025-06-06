import React, { useState, useEffect } from 'react';


export default function EmergencyAlert() {
    const [isPlaying, setIsPlaying] = useState(false);
    const [activeNav, setActiveNav] = useState('alerts');

    const handleAlertClick = () => {
        setIsPlaying(true);
        setTimeout(() => setIsPlaying(false), 3000);
    };

    const handleNavClick = (section) => {
        setActiveNav(section);
    };

    return (
        <div className="min-h-screen bg-gradient-to-b from-red-500 via-orange-500 to-red-600 vibrate-bg relative overflow-hidden">
            <div className="flex justify-between items-center px-4 py-2 text-white text-sm font-medium">
                <div className="flex items-center space-x-1">
                    <div className="w-1 h-1 bg-white rounded-full" />
                    <div className="w-1 h-1 bg-white rounded-full" />
                    <div className="w-1 h-1 bg-white rounded-full opacity-50" />
                    <span className="ml-2">Vivo</span>
                </div>
                <div className="text-center font-bold">9:41</div>
                <div className="flex items-center space-x-1">
                    <i className="fas fa-signal text-xs" />
                    <i className="fas fa-wifi text-xs" />
                    <i className="fas fa-battery-three-quarters text-xs" />
                </div>
            </div>

            <div className="flex flex-col items-center justify-center px-6 py-8 h-[calc(100vh-120px)]">
                <div className="mb-8 relative">
                    <div className="w-24 h-24 bg-white bg-opacity-20 rounded-full flex items-center justify-center pulse-ring">
                        <i className="fas fa-fire text-white text-5xl" />
                    </div>
                </div>

                <div className="text-center mb-12">
                    <h1 className="text-white text-2xl font-bold mb-4 leading-tight">
                        ⚠️ Alerta de risco de<br />incêndio próximo
                    </h1>
                    <p className="text-white text-opacity-90 text-base leading-relaxed">
                        Mantenha-se seguro e siga as<br />instruções de segurança
                    </p>
                </div>

                <div className="relative mb-6">
                    <div className="soundwave w-32 h-32" />
                    <div className="soundwave w-40 h-40" />
                    <div className="soundwave w-48 h-48" />

                    <button
                        onClick={handleAlertClick}
                        className="relative z-10 w-32 h-32 bg-white bg-opacity-20 backdrop-blur-sm border-4 border-white rounded-full flex flex-col items-center justify-center text-white font-bold text-lg hover:bg-opacity-30 transition-all duration-300"
                    >
                        <i className={`fas ${isPlaying ? 'fa-pause' : 'fa-play'} text-2xl mb-1`} />
                        <span className="text-sm">{isPlaying ? 'Pausar' : 'Ouvir'}</span>
                        <span className="text-sm">Alerta</span>
                    </button>
                </div>

                <button className="w-full max-w-xs bg-white bg-opacity-20 backdrop-blur-sm border-2 border-white border-opacity-50 rounded-2xl py-4 px-6 text-white font-semibold text-lg hover:bg-opacity-30 transition-all duration-300">
                    Ver detalhes
                </button>
            </div>

            <nav className="fixed bottom-0 left-0 right-0 bg-white bg-opacity-10 backdrop-blur-md border-t border-white border-opacity-20">
                <div className="flex justify-around items-center py-2">
                    {['alerts', 'shelters', 'checklist', 'psyhelp'].map((nav) => (
                        <div
                            key={nav}
                            onClick={() => handleNavClick(nav)}
                            className="flex flex-col items-center py-2 px-4 cursor-pointer"
                        >
                            <i className={`fas fa-${{
                                alerts: 'bell',
                                shelters: 'home',
                                checklist: 'check-square',
                                psyhelp: 'comments',
                            }[nav]} text-xl mb-1 ${activeNav === nav ? 'text-white' : 'text-white text-opacity-60'}`} />
                            <span className={`text-xs font-medium ${activeNav === nav ? 'text-white' : 'text-white text-opacity-60'}`}>
                                {nav.charAt(0).toUpperCase() + nav.slice(1)}
                            </span>
                        </div>
                    ))}
                </div>
            </nav>
        </div>
    );
}

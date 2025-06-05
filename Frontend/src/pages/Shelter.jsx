import React from 'react';
import './Shelters.css';

export default function Shelters() {
    return (
        <div className="map-3d min-h-screen relative">
            {/* Status */}
            <div className="bg-orange-100 border-l-4 border-orange-500 p-3">
                <div className="flex items-center">
                    <i className="fas fa-exclamation-triangle text-orange-600 mr-2" />
                    <span className="text-sm text-orange-700 font-medium">
                        Situação de emergência ativa - Procure abrigo seguro
                    </span>
                </div>
            </div>

            {/* Mapa e Controles */}
            <div className="relative h-[500px]">
                <svg className="absolute inset-0 w-full h-full" viewBox="0 0 400 500">
                    <defs>
                        <pattern id="grid" width="20" height="20" patternUnits="userSpaceOnUse">
                            <path d="M 20 0 L 0 0 0 20" fill="none" stroke="#e0e7ff" strokeWidth="0.5" />
                        </pattern>
                    </defs>
                    <rect width="100%" height="100%" fill="url(#grid)" opacity="0.3" />

                    {/* Exemplo de prédio */}
                    <g className="building-shadow">
                        <polygon points="50,200 80,200 90,190 60,190" fill="#94a3b8" stroke="#64748b" strokeWidth="1" />
                        <polygon points="80,200 90,190 90,160 80,170" fill="#64748b" />
                        <polygon points="60,190 90,190 90,160 60,160" fill="#cbd5e1" />
                    </g>

                    {/* Rota */}
                    <path d="M 200,400 Q 220,350 240,300 Q 260,250 280,200 Q 300,150 320,100"
                        stroke="#ef4444" strokeWidth="4" fill="none" strokeDasharray="10,5" className="route-line" />

                    {/* Abrigos */}
                    <g transform="translate(315,95)">
                        <circle cx="0" cy="0" r="12" fill="#22c55e" stroke="#ffffff" strokeWidth="2" />
                        <circle cx="0" cy="0" r="18" fill="none" stroke="#22c55e" strokeWidth="2" opacity="0.3" className="pulse-animation" />
                    </g>
                    <g transform="translate(150,160)">
                        <circle cx="0" cy="0" r="10" fill="#f59e0b" stroke="#ffffff" strokeWidth="2" />
                    </g>
                    <g transform="translate(280,280)">
                        <circle cx="0" cy="0" r="10" fill="#f59e0b" stroke="#ffffff" strokeWidth="2" />
                    </g>

                    {/* Localização do usuário */}
                    <g transform="translate(200,400)">
                        <circle cx="0" cy="0" r="8" fill="#3b82f6" className="location-dot" />
                        <circle cx="0" cy="0" r="3" fill="#ffffff" />
                    </g>
                </svg>

                {/* Botões */}
                <div className="absolute top-4 right-4 space-y-2">
                    <button className="map-button">
                        <i className="fas fa-plus text-gray-600" />
                    </button>
                    <button className="map-button">
                        <i className="fas fa-minus text-gray-600" />
                    </button>
                    <button className="map-button">
                        <i className="fas fa-crosshairs text-gray-600" />
                    </button>
                </div>

                <button className="offline-toggle">
                    <i className="fas fa-wifi-slash mr-2" />
                    <span>Modo Offline</span>
                </button>
            </div>
        </div>
    );
}

import React, { useState } from 'react';


export default function ShelterMap() {
    const [offline, setOffline] = useState(true);
    const [startingRoute, setStartingRoute] = useState(false);

    const handleStartRoute = () => {
        setStartingRoute(true);
        setTimeout(() => {
            alert('Rota iniciada! Siga as instruções de navegação.');
            setStartingRoute(false);
        }, 2000);
    };

    const toggleOffline = () => setOffline(!offline);

    return (
        <div className="bg-gray-50 min-h-screen pb-24">
            {/* Header */}
            <header className="bg-white shadow-sm border-b border-gray-200">
                <div className="flex items-center justify-between px-4 py-4">
                    <button className="text-gray-600 hover:text-gray-800">
                        <i className="fas fa-arrow-left text-xl" />
                    </button>
                    <h1 className="text-lg font-bold text-gray-800">Abrigos Próximos</h1>
                    <button className="text-gray-600 hover:text-gray-800">
                        <i className="fas fa-ellipsis-v text-xl" />
                    </button>
                </div>
            </header>

            {/* Emergency Status */}
            <div className="bg-orange-100 border-l-4 border-orange-500 p-3">
                <div className="flex items-center">
                    <i className="fas fa-exclamation-triangle text-orange-600 mr-2" />
                    <span className="text-sm text-orange-700 font-medium">Situação de emergência ativa - Procure abrigo seguro</span>
                </div>
            </div>

            {/* Offline Toggle */}
            <button onClick={toggleOffline} className={`absolute top-4 left-4 px-3 py-2 rounded-lg shadow-md flex items-center text-sm font-medium text-white ${offline ? 'bg-blue-500' : 'bg-green-500'}`}>
                <i className={`fas ${offline ? 'fa-wifi-slash' : 'fa-wifi'} mr-2`} />
                {offline ? 'Modo Offline' : 'Online'}
            </button>

            {/* Map placeholder */}
            <main className="h-[500px] flex items-center justify-center text-gray-500 bg-blue-100 relative">
                <span>Mapa Interativo Aqui (usar SVG ou lib como Leaflet)</span>
            </main>

            {/* Route Info */}
            <div className="bg-white mx-4 my-4 rounded-xl shadow-lg border border-gray-100 p-4">
                <div className="flex items-center justify-between mb-3">
                    <h3 className="text-lg font-bold text-gray-800">Centro Comunitário São João</h3>
                    <span className="bg-green-100 text-green-800 text-xs font-semibold px-2 py-1 rounded-full">87 vagas</span>
                </div>

                <div className="grid grid-cols-2 gap-4 mb-4">
                    <div className="flex items-center">
                        <i className="fas fa-route text-blue-500 mr-2" />
                        <div>
                            <p className="text-sm text-gray-500">Distância</p>
                            <p className="font-semibold text-gray-800">1.2 km</p>
                        </div>
                    </div>
                    <div className="flex items-center">
                        <i className="fas fa-clock text-orange-500 mr-2" />
                        <div>
                            <p className="text-sm text-gray-500">Tempo estimado</p>
                            <p className="font-semibold text-gray-800">8 min a pé</p>
                        </div>
                    </div>
                </div>

                <div className="flex items-center mb-4">
                    <i className="fas fa-shield-alt text-green-500 mr-2" />
                    <span className="text-sm text-gray-600">Abrigo seguro com estrutura para emergências</span>
                </div>

                <div className="grid grid-cols-2 gap-3">
                    <button
                        onClick={handleStartRoute}
                        disabled={startingRoute}
                        className={`${startingRoute ? 'bg-green-500' : 'bg-blue-500 hover:bg-blue-600'
                            } text-white font-semibold py-3 px-4 rounded-lg flex items-center justify-center transition-colors`}
                    >
                        <i className={`fas ${startingRoute ? 'fa-spinner fa-spin' : 'fa-play'} mr-2`} />
                        {startingRoute ? 'Iniciando...' : 'Iniciar Rota'}
                    </button>

                    <button
                        onClick={() => window.location.href = 'tel:+551133334444'}
                        className="bg-gray-100 hover:bg-gray-200 text-gray-700 font-semibold py-3 px-4 rounded-lg flex items-center justify-center transition-colors"
                    >
                        <i className="fas fa-phone mr-2" />Ligar
                    </button>
                </div>
            </div>

            {/* Lista de Abrigos */}
            <div className="mx-4 mb-20">
                <h3 className="text-lg font-bold text-gray-800 mb-3">Outros Abrigos Próximos</h3>

                <div className="space-y-3">
                    <div className="bg-white rounded-lg p-4 shadow-sm border border-gray-100">
                        <div className="flex items-center justify-between">
                            <div className="flex-1">
                                <h4 className="font-semibold text-gray-800">Escola Municipal Santos</h4>
                                <p className="text-sm text-gray-500">2.1 km • 12 min a pé</p>
                            </div>
                            <div className="text-right">
                                <span className="bg-yellow-100 text-yellow-800 text-xs font-semibold px-2 py-1 rounded-full">23 vagas</span>
                            </div>
                        </div>
                    </div>

                    <div className="bg-white rounded-lg p-4 shadow-sm border border-gray-100">
                        <div className="flex items-center justify-between">
                            <div className="flex-1">
                                <h4 className="font-semibold text-gray-800">Igreja São José</h4>
                                <p className="text-sm text-gray-500">1.8 km • 10 min a pé</p>
                            </div>
                            <div className="text-right">
                                <span className="bg-red-100 text-red-800 text-xs font-semibold px-2 py-1 rounded-full">5 vagas</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
